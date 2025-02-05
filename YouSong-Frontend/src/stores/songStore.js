import {ref} from 'vue'
import {defineStore} from 'pinia'
import axios from "axios";

export const useSongStore = defineStore('songStore', () => {
    const currentSong = ref({
        id: null,
        title: null,
        artist: null,
        genre: null,
        length: null
    });
    const songs = ref();
    getAllSongs();

    const edit = ref(false);

    function changeSong(id) {
        currentSong.value = songs.value.filter((song) => song.id == id)[0];
    }

    function createSong(title, artist, genre, length) {
        axios.post("http://localhost:8888/api/songs", {
            title: title,
            artist: artist,
            genre: genre,
            length: parseTime(length),
        }).then(() => {getAllSongs()});
    }

    function editSong(id, title, artist, genre, length) {
        axios.put(`http://localhost:8888/api/songs/${id}`, {
            title: title,
            artist: artist,
            genre: genre,
            length: parseTime(length),
        }).then(() => {getAllSongs()});
    }

    function parseTime(time) {
        let result = new Date();
        let sections = time.split(":");
        result.setSeconds(sections[sections.length - 1]);
        if (sections.length > 1) {
            result.setMinutes(sections[sections.length - 2]);
        } else {
            result.setMinutes(0);
        }
        if (sections.length > 2) {
            result.setHours(sections[sections.length - 3]);
        } else {
            result.setHours(0);
        }

        return result.toTimeString().split(" ")[0];
    }

    function getAllSongs() {
        return axios.get("http://localhost:8888/api/songs").then((res) => {songs.value=res.data;});
    }

    return {song: currentSong, changeSong, edit, songs, editSong, createSong};
});
