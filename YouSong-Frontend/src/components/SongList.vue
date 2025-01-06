<script setup>

import Song from "@/components/Song.vue";
import axios from "axios";


let songs = await axios.get("http://localhost:8888/api/songs");
</script>

<template>
  <div class="flex flex-wrap justify-center p-16 w-full sm:w-2/3">
  <Song v-for="song in songs.data" :title="song.title" :artist="song.artist" :genre="song.genre"
        :length="song.length" :id="song.id"></Song>
  </div>
</template>