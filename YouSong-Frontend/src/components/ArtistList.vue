<script setup>
import {useArtistStore} from "@/stores/artistStore.js";
import Artist from "@/components/Artist.vue";
import PageSelector from "@/components/PageSelector.vue";

const artistStore = useArtistStore();
</script>

<template>
  <div class="flex flex-col w-full items-center">
    <div class="flex flex-wrap justify-center p-16 w-full sm:w-2/3">
      <Artist v-for="artist in artistStore.artists" :name="artist.name" :id="artist.id"></Artist>
    </div>
    <PageSelector></PageSelector>
  </div>
</template>