import {defineStore} from "pinia";
import {ref} from "vue";
import axios from "axios";

export const useArtistStore = defineStore('artistStore', () => {
    const artists = ref([]);
    getArtists();

    function getArtists() {
        return axios.get("http://localhost:8888/api/artists").then((res) => {
            artists.value = res.data;
        });
    }

    function deleteArtist(id) {
        console.log(id);
        axios.delete(`http://localhost:8888/api/artists/`+id).then((res) => {getArtists();});
    }

    return {artists, getArtists, deleteArtist};
});