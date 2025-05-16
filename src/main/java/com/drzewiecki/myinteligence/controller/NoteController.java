package com.drzewiecki.myinteligence.controller;

import com.drzewiecki.myinteligence.service.note.Note;
import com.drzewiecki.myinteligence.service.note.NoteDto;
import com.drzewiecki.myinteligence.service.note.NoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("notes")
public class NoteController {

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
