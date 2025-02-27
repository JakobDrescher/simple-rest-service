import {defineStore} from "pinia";
import {ref} from "vue";
import axios from "axios";

export const useArtistStore = defineStore('artistStore', () => {
    const currentArtist = ref({
        id: null,
        name: null
    });

    const artists = ref([]);
    const searchTerm = ref ("");
    getArtists();

    const edit = ref(false);

    function changeArtist(id=null) {
        if (id!=null) {
            currentArtist.value = artists.value.filter((artist) => artist.id == id)[0];
        }else{
            currentArtist.value = {
                id: null,
                name: null
            }
        }
    }

    function getArtists() {
        if(searchTerm.value == "") {
            return axios.get("http://localhost:8888/api/artists").then((res) => {
                artists.value = res.data.content;
            });
        }else{
            return axios.get("http://localhost:8888/api/artists/"+searchTerm.value).then((res) => {
            artists.value = res.data.content;
        });
        }
    }

    function createArtist(name) {
        axios.post("http://localhost:8888/api/artists", {
            name: name
        }).then(() => {getArtists()});
    }

    function editArtist(id, name) {
        axios.put(`http://localhost:8888/api/artists/${id}`, {
            name: name
        }).then(() => {getArtists()});
    }

    function deleteArtist(id) {
        axios.delete(`http://localhost:8888/api/artists/`+id).then((res) => {getArtists();});
    }

    return {artists, getArtists, deleteArtist,searchTerm,currentArtist,edit,changeArtist,createArtist,editArtist};
});