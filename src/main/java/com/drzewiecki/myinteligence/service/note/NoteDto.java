package com.drzewiecki.myinteligence.service.note;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Accessors(chain = true)
public class NoteDto {

    private Long id;

    private String text;

    private String type;

    private String user;

    public static List<NoteDto> of(List<Note> notes) {
        return notes.stream()
                .map(NoteDto::of)
                .collect(Collectors.toList());
    }

    public static NoteDto of(Note n) {
        return new NoteDto()
                .setId(n.getId())
                .setText(n.getText())
                .setType(n.getType())
                .setUser(n.getUser());
    }
}
