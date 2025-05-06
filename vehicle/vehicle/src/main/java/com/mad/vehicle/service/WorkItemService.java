package com.mad.vehicle.service;

import com.mad.vehicle.entity.WorkItem;
import com.mad.vehicle.repo.WorkItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkItemService {
    @Autowired private WorkItemRepository repo;
    public List<WorkItem> getAll() { return repo.findAll(); }
    public WorkItem save(WorkItem w) { return repo.save(w); }
    public Optional<WorkItem> getById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}