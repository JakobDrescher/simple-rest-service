import {createRouter, createWebHistory} from "vue-router";

import SongList from "@/components/SongList.vue";
import SongEditor from "@/components/SongEditor.vue";
import ArtistList from "@/components/ArtistList.vue";
import ArtistEditor from "@/components/ArtistEditor.vue";


const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: "/",
            name: 'home',
            component: SongList
        },
        {
            path: "/songs/editor",
            name: 'songEditor',
            component: SongEditor
        },
        {
            path: "/artists",
            name: 'artists',
            component: ArtistList
        },
        {
            path: "/artists/editor",
            name: 'artistEditor',
            component: ArtistEditor
        }
    ]
});

export default router;