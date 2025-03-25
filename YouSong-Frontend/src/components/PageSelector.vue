<script setup>

import {useSongStore} from "@/stores/songStore.js";
import {useArtistStore} from "@/stores/artistStore.js";
import {ref} from "vue";
import {useRoute} from "vue-router";

const songStore = useSongStore();
const artistStore = useArtistStore();
const page = ref(1);
const route = useRoute();

function changePage(method) {
  if (route.name === 'home') {
    switch (method) {
      case 'next':
        if (songStore.pageInfo.number < songStore.pageInfo.totalPages - 1) {
          songStore.pageInfo.number++;
        }
        break;
      case 'previous':
        if (songStore.pageInfo.number > 0) {
          songStore.pageInfo.number--;
        }
        break;
      case 'first':
        songStore.pageInfo.number = 0;
        break;
      case 'last':
        songStore.pageInfo.number = songStore.pageInfo.totalPages - 1;
    }
    songStore.getSongs();
    page.value = songStore.pageInfo.number + 1;
  }
  if (route.name === 'artists') {
    switch (method) {
      case 'next':
        if (artistStore.pageInfo.number < artistStore.pageInfo.totalPages - 1) {
          artistStore.pageInfo.number++;
        }
        break;
      case 'previous':
        if (artistStore.pageInfo.number > 0) {
          artistStore.pageInfo.number--;
        }
        break;
      case 'first':
        artistStore.pageInfo.number = 0;
        break;
      case 'last':
        artistStore.pageInfo.number = artistStore.pageInfo.totalPages - 1;
    }
    artistStore.getArtists();
    page.value = artistStore.pageInfo.number + 1;
  }
}
</script>

<template>
  <div class="flex size-56">
    <button class="p-2 border border-black rounded-l size-1/5 flex justify-center items-center"
            @click="changePage('first')">
      <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor"
           class="size-6">
        <path stroke-linecap="round" stroke-linejoin="round" d="m18.75 4.5-7.5 7.5 7.5 7.5m-6-15L5.25 12l7.5 7.5"/>
      </svg>
    </button>
    <button class="p-2 border border-black size-1/5 flex justify-center items-center" @click="changePage('previous')">
      <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor"
           class="size-6">
        <path stroke-linecap="round" stroke-linejoin="round" d="M15.75 19.5 8.25 12l7.5-7.5"/>
      </svg>
    </button>
    <span class="border border-black size-1/5 flex justify-center items-center">{{ page }}</span>
    <button class="p-2 border border-black size-1/5 flex justify-center items-center" @click="changePage('next')">
      <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor"
           class="size-6">
        <path stroke-linecap="round" stroke-linejoin="round" d="m8.25 4.5 7.5 7.5-7.5 7.5"/>
      </svg>
    </button>
    <button class="p-2 border border-black rounded-r size-1/5 flex justify-center items-center"
            @click="changePage('last')">
      <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor"
           class="size-6">
        <path stroke-linecap="round" stroke-linejoin="round" d="m5.25 4.5 7.5 7.5-7.5 7.5m6-15 7.5 7.5-7.5 7.5"/>
      </svg>
    </button>
  </div>
</template>