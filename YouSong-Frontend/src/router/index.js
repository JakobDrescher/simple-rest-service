import {createRouter, createWebHistory} from "vue-router";

import SongList from "@/components/SongList.vue";
import SongEditor from "@/components/SongEditor.vue";
import ArtistList from "@/components/ArtistList.vue";


const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: "/",
            name: 'home',
            component: SongList
        },
        {
            path: "/editor",
            name: 'editor',
            component: SongEditor
        },
        {
            path: "/artists",
            name: 'artists',
            component: ArtistList
        }
    ]
});

export default router;