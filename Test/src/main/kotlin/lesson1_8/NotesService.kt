package lesson1_8

class NotesService() {

    private val notes = mutableListOf<Note>()
    private val removedNotes = mutableListOf<Note>()
    private val comments = mutableListOf<CommentToNote>()
    private val removedComments = mutableListOf<CommentToNote>()

    fun addNote(note: Note): Note? {
        if(note.remove == true) {
            return throw NoteDeletedEarlierException("Заметка была ранее удалена")
        }
        val lastId = notes.lastOrNull()?.id ?: 0
        notes.add(note.copy(id = lastId + 1))
        return notes.last()
    }

    fun createCommentToNote(comment: CommentToNote): Boolean? {
        if(comment.remove == true) {
            return throw NoteRemovedException("Комментарий был ранее удален")
        }
        for(note in notes) {
            if(note.id == comment.noteId) {
                comments.add(comment)
                return true
            }
        }
        return throw UnknownException("Неизвестная ошибка")
    }

    fun deleteNote(note: Note): Boolean? {
        if(note.remove == true) {
            return throw NoteDeletedEarlierException("Заметка была ранее удалена")
        }
        note.remove = true
        removedNotes.add(note)
        notes.remove(note)
        return true
    }

    fun deleteComment(comment: CommentToNote): Boolean? {
        if(comment.remove == true) {
            return throw CommentRemovedException("Комментарий был ранее удален")
        }
        comment.remove = true
        removedComments.add(comment)
        comments.remove(comment)
        return true
    }

    fun editNote(note: Note): Boolean? {
        if (note.remove == true) {
            return throw NoteDeletedEarlierException("Заметка была ранее удалена")
        }
        if(notes.isEmpty()) return throw ListOfNotesIsEptyException("Список для заметок пуст")
        val oldNoteIndex = notes.indexOf(note)
        notes.set(oldNoteIndex, note)
        return true
    }

    fun editComment(comment: CommentToNote): Boolean? {
        if (comment.remove == true) {
            return throw CommentRemovedException("Комментарий был ранее удален")
        }
        if(comments.isEmpty()) return throw CommentIsNotFoundException("Комментарий для редактирования не найден")
        val oldCommentIndex = comments.indexOf(comment)
        comments.set(oldCommentIndex, comment)
        return true
    }

    fun getAllNotes(): MutableList<Note>? {
        if(notes.isEmpty() == true) {
            return throw NotCreatedNotesException("Список заметок пуст.")
        }
        return notes
    }

    fun getNoteById(noteId: Long): Note? {
        if(notes.isEmpty() == true) {
            return throw NotCreatedNotesException("Список заметок пуст.")
        }
        val id = noteId
        for(note in notes) {
            if (note.id == id) {
                return note
            }
            else {
                return throw NoFindIdNoteException("Заметки с указанным id не существует или она не была найдена")
            }
        }
        return throw UnknownException("Неизвестная ошибка")
    }

    fun restoreCommentToNote(commentId: Long): Boolean? {
        val id = commentId
        for(comment in removedComments) {
            if (comment.id == id && comment.remove == true) {
                removedComments.remove(comment)
                comments.add(comment)
                return true
            }
        }
        return throw NoFindIdCommentException("Комментарий не найден")
    }
}