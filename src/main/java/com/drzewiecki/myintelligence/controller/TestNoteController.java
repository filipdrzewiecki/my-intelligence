package com.drzewiecki.myintelligence.controller;

import com.drzewiecki.myintelligence.service.note.Note;
import com.drzewiecki.myintelligence.service.note.NoteDto;
import com.drzewiecki.myintelligence.service.note.NoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("notes")
public class TestNoteController {

    private final NoteService noteService;

    @GetMapping
    public List<NoteDto> getAllNotes() {
        List<Note> notes = noteService.getNotes();
        return NoteDto.of(notes);
    }

    @PostMapping
    public NoteDto addNote(@RequestBody NoteDto noteDto) {
        Note note = noteService.addNote(noteDto);
        return NoteDto.of(note);
    }
}
