package com.book.novels.controller;

import com.example.novels.model.Novel;
import com.example.novels.service.NovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/novels")
public class NovelController {

    @Autowired
    private NovelService novelService;

    @GetMapping
    public List<Novel> getAllNovels() {
        return novelService.getAllNovels();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Novel> getNovelById(@PathVariable Long id) {
        return novelService.getNovelById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Novel createNovel(@RequestBody Novel novel) {
        return novelService.createNovel(novel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Novel> updateNovel(@PathVariable Long id, @RequestBody Novel novelDetails) {
        return ResponseEntity.ok(novelService.updateNovel(id, novelDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNovel(@PathVariable Long id) {
        novelService.deleteNovel(id);
        return ResponseEntity.noContent().build();
    }
}
