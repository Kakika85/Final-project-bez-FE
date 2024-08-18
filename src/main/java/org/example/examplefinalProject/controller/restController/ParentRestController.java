package org.example.examplefinalProject.controller.restController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.examplefinalProject.entity.Parent;
import org.example.examplefinalProject.service.ParentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/parent")

public class ParentRestController {
    private final ParentService parentService;

    @GetMapping("")
    public ResponseEntity<List<Parent>> index() {
        return ResponseEntity.ok(parentService.findAll());
    }

    /*@GetMapping("/{parentId}")
    public ResponseEntity<Parent> detail(@PathVariable int parentId) {
        Parent parent = parentService.findById(parentId);
        if (parent != null) {
            return ResponseEntity.ok(parent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/

    @DeleteMapping("/deleteParent/{parentId}")
    public ResponseEntity<String> deleteParent(@PathVariable Integer parentId) {
        parentService.deleteParent(parentId);
        return ResponseEntity.noContent().build();
    }
}