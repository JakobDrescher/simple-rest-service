import {defineStore} from "pinia";
import {ref} from "vue";
import axios from "axios";

export const useArtistStore = defineStore('artistStore', () => {
    const currentArtist = ref({
        id: null,
        name: null
    });

    const pageInfo = ref({
        number: 0,
        totalPages: null,
    })

    const artists = ref([]);
    const searchTerm = ref("");
    getArtists();

    const edit = ref(false);

    function changeArtist(id = null) {
        if (id != null) {
            currentArtist.value = artists.value.filter((artist) => artist.id == id)[0];
        } else {
            currentArtist.value = {
                id: null,
                name: null
            }
        }
    }

    function getArtists() {
        let number = pageInfo.value.number;
        if (searchTerm.value == "") {
            return axios.get("http://localhost:8888/api/artists", {params: {page: number}}).then((res) => {
                artists.value = res.data.content;
                pageInfo.value.number = res.data.number;
                pageInfo.value.totalPages = res.data.totalPages;
            });
        } else {
            return axios.get("http://localhost:8888/api/artists/" + searchTerm.value, {params: {page: number}}).then((res) => {
                artists.value = res.data.content;
                pageInfo.value.number = res.data.number;
                pageInfo.value.totalPages = res.data.totalPages;
            });
        }
    }

    function createArtist(name) {
        axios.post("http://localhost:8888/api/artists", {
            name: name
        }).then(() => {
            getArtists()
        });
    }

    function editArtist(id, name) {
        axios.put(`http://localhost:8888/api/artists/${id}`, {
            name: name
        }).then(() => {
            getArtists()
        });
    }

    function deleteArtist(id) {
        axios.delete(`http://localhost:8888/api/artists/` + id).then((res) => {
            getArtists();
        });
    }

    return {
        artists,
        getArtists,
        deleteArtist,
        searchTerm,
        currentArtist,
        edit,
        changeArtist,
        createArtist,
        editArtist,
        pageInfo
    };
});