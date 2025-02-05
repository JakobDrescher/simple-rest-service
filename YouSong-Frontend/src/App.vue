<script setup>
import SongList from "@/components/SongList.vue";
import {useSongStore} from "@/stores/songStore.js";
import axios from "axios";
import {ref} from "vue";

const songStore = useSongStore();
</script>

<template>
  <nav class="bg-black p-5 flex flex-row justify-evenly items-center">
    <h1 class="text-white font-extrabold text-6xl pb-3 cursor-pointer" @click="songStore.changeSong(); songStore.edit=false; $router.push('/')">YouSong</h1>
    <input v-if="$route.name!='editor'" type="text" class="shadow appearance-none border rounded w-1/3 py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" placeholder="Title or Artist" v-model="songStore.searchTerm" @input="songStore.getSongs()">
    <button class="bg-white text-black rounded p-3 h-fit" @click="$router.push('editor')">
      <span class="font-bold">Add Song</span>
    </button>
  </nav>
  <div class="flex justify-center">
    <Suspense fallback="loading">
      <router-view></router-view>
    </Suspense>
  </div>
</template>