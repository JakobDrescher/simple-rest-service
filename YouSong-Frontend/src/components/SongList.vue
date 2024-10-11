<script setup>

import Song from "@/components/Song.vue";
import axios from "axios";


let songs = await axios.get("http://localhost:8888/api/songs");
</script>

<template>
  <div class="flex flex-wrap">
  <Song v-for="song in songs.data" :title="song.title" :artist="song.artist" :genre="song.genre"
        :length="song.length"></Song>
  </div>
</template>