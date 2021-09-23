package com.enessetere.lfw.review;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.Objects;

@Setter(value = AccessLevel.PRIVATE)
@Getter
public class Note {
    private Map<String, Short> notes;
    private double average;

    private Note() {
    }

    public static class Builder {
        private final Note note;
        public Builder() {
            this.note = new Note();
        }

        public Builder notes(Map<String, Short> notes) {
            note.setNotes(notes);
            return this;
        }

        public Note build() {
            short notesSum = 0;
            short count = 0;
            for (Short noteValue : note.notes.values()) {
                if (Objects.nonNull(noteValue)) {
                    notesSum += noteValue;
                    count++;
                }
            }
            this.note.setAverage(notesSum/(double)count);
            return note;
        }
    }
}
