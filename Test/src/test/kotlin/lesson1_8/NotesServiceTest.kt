package lesson1_8

import org.junit.Test

import org.junit.Assert.*

internal class NotesServiceTest {

    @Test(expected = NoteDeletedEarlierException::class)
    fun addNote_removedNote() {

        val notesService = NotesService()

        val note = Note(
            id = 1,
            ownerId = 2,
            title = "Note",
            text = "Note",
            date = 1,
            comments = 1,
            readComments = 1,
            viewUrl = "www.leningrad.ru",
            remove = true
        )

        notesService.addNote(note)
    }

    @Test
    fun addNote_successAdd() {

        val notesService = NotesService()

        val note = Note(
            id = 0,
            ownerId = 2,
            title = "Note",
            text = "Note",
            date = 1,
            comments = 1,
            readComments = 1,
            viewUrl = "www.leningrad.ru",
            remove = false
        )

        val secondNote = note.copy(id = 1)
        val result= notesService.addNote(note)


        assertEquals(secondNote, result)
    }

    @Test(expected = NoteRemovedException::class)
    fun createComment_removedComment() {

        val notesService = NotesService()

        val comment = CommentToNote(
            noteId = 1,
            id = 1,
            fromId = 1,
            date = 1,
            text = "Comment",
            replyToUser = 1,
            replyToComment = 1,
            attachments = null,
            parentsStack = emptyArray(),
            remove = true
        )

        notesService.createCommentToNote(comment)
    }

    @Test
    fun createComment_successCreate() {

        val notesService = NotesService()

        val note = Note(
            id = 0,
            ownerId = 2,
            title = "Note",
            text = "Note",
            date = 1,
            comments = 1,
            readComments = 1,
            viewUrl = "www.leningrad.ru",
            remove = false
        )

        val comment = CommentToNote(
            noteId = 1,
            id = 1,
            fromId = 1,
            date = 1,
            text = "Comment",
            replyToUser = 1,
            replyToComment = 1,
            attachments = null,
            parentsStack = emptyArray(),
            remove = false
        )

        notesService.addNote(note)
        val result = notesService.createCommentToNote(comment)

        assertTrue(result!!)
    }

    @Test(expected = NoteDeletedEarlierException::class)
    fun deleteNote_removedNote() {

        val notesService = NotesService()

        val note = Note(
            id = 1,
            ownerId = 2,
            title = "Note",
            text = "Note",
            date = 1,
            comments = 1,
            readComments = 1,
            viewUrl = "www.leningrad.ru",
            remove = true
        )

        notesService.deleteNote(note)
    }

    @Test
    fun deleteNote_successRemove() {

        val notesService = NotesService()

        val note = Note(
            id = 1,
            ownerId = 2,
            title = "Note",
            text = "Note",
            date = 1,
            comments = 1,
            readComments = 1,
            viewUrl = "www.leningrad.ru",
            remove = false
        )

        notesService.addNote(note)
        val result = notesService.deleteNote(note)

        assertTrue(result!!)
    }

    @Test(expected = CommentRemovedException::class)
    fun deleteComment_removedComment() {

        val notesService = NotesService()

        val comment = CommentToNote(
            noteId = 1,
            id = 1,
            fromId = 1,
            date = 1,
            text = "Comment",
            replyToUser = 1,
            replyToComment = 1,
            attachments = null,
            parentsStack = emptyArray(),
            remove = true
        )

        notesService.deleteComment(comment)
    }

    @Test
    fun deleteComment_successRemove() {

        val notesService = NotesService()

        val comment = CommentToNote(
            noteId = 1,
            id = 1,
            fromId = 1,
            date = 1,
            text = "Comment",
            replyToUser = 1,
            replyToComment = 1,
            attachments = null,
            parentsStack = emptyArray(),
            remove = false
        )

        val result = notesService.deleteComment(comment)

        assertTrue(result!!)
    }

    @Test(expected = NoteDeletedEarlierException::class)
    fun editNote_removedNote() {

        val notesService = NotesService()

        val note = Note(
            id = 1,
            ownerId = 2,
            title = "Note",
            text = "Note",
            date = 1,
            comments = 1,
            readComments = 1,
            viewUrl = "www.leningrad.ru",
            remove = true
        )

        notesService.editNote(note)
    }

    @Test(expected = ListOfNotesIsEptyException::class)
    fun editNote_emptyListOfNotes() {

        val notesService = NotesService()

        val note = Note(
            id = 1,
            ownerId = 2,
            title = "Note",
            text = "Note",
            date = 1,
            comments = 1,
            readComments = 1,
            viewUrl = "www.leningrad.ru",
            remove = false
        )

        notesService.editNote(note)
    }

    @Test
    fun editNote_successEdit() {

        val notesService = NotesService()

        val note = Note(
            id = 1,
            ownerId = 2,
            title = "Note",
            text = "Note",
            date = 1,
            comments = 1,
            readComments = 1,
            viewUrl = "www.leningrad.ru",
            remove = false
        )

        notesService.addNote(note)
        val result = notesService.editNote(note)

        assertTrue(result!!)
    }

@Test(expected = CommentRemovedException::class)
fun editComment_removedComment() {

    val notesService = NotesService()

    val comment = CommentToNote(
        noteId = 1,
        id = 1,
        fromId = 1,
        date = 1,
        text = "Comment",
        replyToUser = 1,
        replyToComment = 1,
        attachments = null,
        parentsStack = emptyArray(),
        remove = true
    )

    notesService.editComment(comment)
}

    @Test(expected = CommentIsNotFoundException::class)
    fun editComment_emptyListOfComment() {

        val notesService = NotesService()

        val comment = CommentToNote(
            noteId = 1,
            id = 1,
            fromId = 1,
            date = 1,
            text = "Comment",
            replyToUser = 1,
            replyToComment = 1,
            attachments = null,
            parentsStack = emptyArray(),
            remove = false
        )

        notesService.editComment(comment)
    }

    @Test
    fun editComment_successEdit() {

        val notesService = NotesService()

        val comment = CommentToNote(
            noteId = 1,
            id = 1,
            fromId = 1,
            date = 1,
            text = "Comment",
            replyToUser = 1,
            replyToComment = 1,
            attachments = null,
            parentsStack = emptyArray(),
            remove = false
        )

        val note = Note(
            id = 0,
            ownerId = 2,
            title = "Note",
            text = "Note",
            date = 1,
            comments = 1,
            readComments = 1,
            viewUrl = "www.leningrad.ru",
            remove = false
        )

        notesService.addNote(note)
        notesService.createCommentToNote(comment)
        val result = notesService.editComment(comment)

        assertTrue(result!!)
    }

    @Test(expected = NotCreatedNotesException::class)
    fun getAllNotes_ListOfNosteIsEmpty() {

        val notesService = NotesService()
        notesService.getAllNotes()
    }

    @Test
    fun getAllNotes_successGet() {

        val notesService = NotesService()

        val note = Note(
            id = 1,
            ownerId = 2,
            title = "Note",
            text = "Note",
            date = 1,
            comments = 1,
            readComments = 1,
            viewUrl = "www.leningrad.ru",
            remove = false
        )

        notesService.addNote(note)
        notesService.addNote(note)
        notesService.addNote(note)
        val result = notesService.getAllNotes()

        assertTrue(result is MutableList)
    }

    @Test(expected = NotCreatedNotesException::class)
    fun getNoteById_EmptyListOfNotes() {

        val notesService = NotesService()

        notesService.getNoteById(1)
    }

    @Test
    fun getNoteById_successFind() {

        val notesService = NotesService()

        val note = Note(
            id = 1,
            ownerId = 2,
            title = "Note",
            text = "Note",
            date = 1,
            comments = 1,
            readComments = 1,
            viewUrl = "www.leningrad.ru",
            remove = false
        )
        notesService.addNote(note)
        val result = notesService.getNoteById(1)

        assertTrue(result is Note)
    }

    @Test(expected = NoFindIdNoteException::class)
    fun getNoteById_noteNotFind() {

        val notesService = NotesService()

        val note = Note(
            id = 1,
            ownerId = 2,
            title = "Note",
            text = "Note",
            date = 1,
            comments = 1,
            readComments = 1,
            viewUrl = "www.leningrad.ru",
            remove = false
        )
        notesService.addNote(note)
        notesService.getNoteById(2)
    }


    @Test
    fun restoreCommentToNote_successRestore() {

        val notesService = NotesService()

        val comment = CommentToNote(
            noteId = 1,
            id = 1,
            fromId = 1,
            date = 1,
            text = "Comment",
            replyToUser = 1,
            replyToComment = 1,
            attachments = null,
            parentsStack = emptyArray(),
            remove = false
        )

        val note = Note(
            id = 0,
            ownerId = 2,
            title = "Note",
            text = "Note",
            date = 1,
            comments = 1,
            readComments = 1,
            viewUrl = "www.leningrad.ru",
            remove = false
        )

        notesService.addNote(note)
        notesService.createCommentToNote(comment)
        notesService.deleteComment(comment)
        val result = notesService.restoreCommentToNote(1)

        assertTrue(result!!)
    }

    @Test(expected = NoFindIdCommentException::class)
    fun restoreCommentToNote_NotFindId() {

        val notesService = NotesService()

        val comment = CommentToNote(
            noteId = 1,
            id = 1,
            fromId = 1,
            date = 1,
            text = "Comment",
            replyToUser = 1,
            replyToComment = 1,
            attachments = null,
            parentsStack = emptyArray(),
            remove = false
        )

        val note = Note(
            id = 0,
            ownerId = 2,
            title = "Note",
            text = "Note",
            date = 1,
            comments = 1,
            readComments = 1,
            viewUrl = "www.leningrad.ru",
            remove = false
        )

        notesService.addNote(note)
        notesService.createCommentToNote(comment)
        notesService.deleteComment(comment)
        notesService.restoreCommentToNote(2)
    }
}