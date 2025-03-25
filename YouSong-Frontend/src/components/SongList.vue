<script setup>

import Song from "@/components/Song.vue";
import {useSongStore} from "@/stores/songStore.js";
import PageSelector from "@/components/PageSelector.vue";

const songStore = useSongStore();
</script>

<template>
  <div class="flex flex-col w-full items-center">
    <div class="flex flex-wrap justify-center p-16 w-full sm:w-2/3">
      <Song v-if="songStore.songs.length>0" v-for="song in songStore.songs" :title="song.title" :artist="song.artist"
            :genre="song.genre"
            :length="song.length" :id="song.id"></Song>
      <span v-else>No songs can be found. Please adjust your search.</span>
    </div>
    <PageSelector></PageSelector>
  </div>
</template>