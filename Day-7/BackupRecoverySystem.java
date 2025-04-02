package Day7;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.text.*;

class FileMetadata implements Serializable {
    private String fileName;
    private long fileSize;
    private long lastModified;

    public FileMetadata(String fileName, long fileSize, long lastModified) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.lastModified = lastModified;
    }

    public String getFileName() {
        return fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public long getLastModified() {
        return lastModified;
    }

    @Override
    public String toString() {
        return "File Name: " + fileName + ", Size: " + fileSize + " bytes, Last Modified: " + new Date(lastModified);
    }
}

public class BackupRecoverySystem {

    private static final String BACKUP_DIR = "backup/";
    private static final String METADATA_FILE = "backup_metadata.dat";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory to back up: ");
        String sourceDirectory = scanner.nextLine();

        try {
            backupFiles(sourceDirectory);
            recoverFiles();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void backupFiles(String sourceDirectory) throws IOException {
        File sourceDir = new File(sourceDirectory);
        if (!sourceDir.exists() || !sourceDir.isDirectory()) {
            System.out.println("Invalid directory.");
            return;
        }

        File backupDir = new File(BACKUP_DIR);
        if (!backupDir.exists()) {
            backupDir.mkdir();
        }

        List<FileMetadata> metadataList = new ArrayList<>();
        
        // Copy each file from source to backup folder
        for (File file : sourceDir.listFiles()) {
            if (file.isFile()) {
                String backupFilePath = BACKUP_DIR + file.getName();
                copyFile(file, new File(backupFilePath));
                metadataList.add(new FileMetadata(file.getName(), file.length(), file.lastModified()));
            }
        }

        // Serialize metadata to a file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(METADATA_FILE))) {
            oos.writeObject(metadataList);
        }
        System.out.println("Backup complete with metadata saved.");
    }

    public static void copyFile(File source, File dest) throws IOException {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }

    public static void recoverFiles() throws IOException, ClassNotFoundException {
        File backupDir = new File(BACKUP_DIR);
        if (!backupDir.exists()) {
            System.out.println("No backup found.");
            return;
        }

        // Deserialize metadata from file
        List<FileMetadata> metadataList;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(METADATA_FILE))) {
            metadataList = (List<FileMetadata>) ois.readObject();
        }

        // Recover files from backup folder
        for (FileMetadata metadata : metadataList) {
            File backupFile = new File(backupDir, metadata.getFileName());
            File restoredFile = new File(metadata.getFileName());
            copyFile(backupFile, restoredFile);
            System.out.println("Restored file: " + metadata);
        }
    }
}
