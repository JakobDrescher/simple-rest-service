<script setup>

import Song from "@/components/Song.vue";
import {useSongStore} from "@/stores/songStore.js";

const songStore = useSongStore();
</script>

<template>
  <div class="flex flex-wrap justify-center p-16 w-full sm:w-2/3">
  <Song v-for="song in songStore.songs" :title="song.title" :artist="song.artist" :genre="song.genre"
        :length="song.length" :id="song.id"></Song>
  </div>
</template>