package com.drzewiecki.myintelligence.service.note;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    public List<Note> getNotes() {
        return noteRepository.findAll();
    }

    public Note addNote(NoteDto noteDto) {
        Note note = new Note();
        note.setText(noteDto.getText());
        note.setType(noteDto.getType());
        note.setUser("John Smith");
        return noteRepository.save(note);
    }
}
