import {ref} from 'vue'
import {defineStore} from 'pinia'

export const useSongStore = defineStore('songStore', () => {
    const song = ref({
        id: null,
        title: null,
        artist: null,
        genre: null,
        length: null
    });

    const edit = ref(false);

    function changeSong(id, title, artist, genre, length) {
        song.value = {
            id: id,
            title: title,
            artist: artist,
            genre: genre,
            length: length
        };
    }

    return {song, changeSong, edit}
});
