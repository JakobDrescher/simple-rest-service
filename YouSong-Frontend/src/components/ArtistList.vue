<script setup>
import {useArtistStore} from "@/stores/artistStore.js";
import Artist from "@/components/Artist.vue";

const artistStore = useArtistStore();
</script>

<template>
  <div class="flex flex-wrap justify-center p-16 w-full sm:w-2/3">
    <Artist v-for="artist in artistStore.artists" :name="artist.name" :id="artist.id"></Artist>
  </div>
</template>