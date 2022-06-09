package com.eliassen.demo.contoller;

import com.eliassen.demo.model.Metadata;
import com.eliassen.demo.repository.MetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MetadataController {

    @Autowired
    MetadataRepository metadataRepository;

    @GetMapping("/metadata")
    public List<Metadata> getAllMetadatas() {
        return metadataRepository.findAll();
    }

    @GetMapping("/metadata/{resourceId}")
    public Metadata getMetadataWithResourceId(@PathVariable String resourceId) {
        return metadataRepository.findById(resourceId).get();
    }


    @DeleteMapping("/metadata/{resourceId}")
    public void deleteMetadataWithResourceId(@PathVariable String resourceId) {
        metadataRepository.deleteById(resourceId);
    }


    @PostMapping("/metadata")
    public List<Metadata> deleteMetadataWithResourceId(@RequestBody List<Metadata> metadata) {
        return metadataRepository.saveAll(metadata);
    }
}
