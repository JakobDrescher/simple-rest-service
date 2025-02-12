<script setup>
import SongList from "@/components/SongList.vue";
import {useSongStore} from "@/stores/songStore.js";
import axios from "axios";
import {ref} from "vue";

const songStore = useSongStore();
</script>

<template>
  <nav class="bg-black p-5 flex flex-row justify-evenly items-baseline">
    <h1 class="text-white font-extrabold text-6xl pb-3 cursor-pointer"
        @click="songStore.changeSong(); songStore.edit=false; $router.push('/')">YouSong</h1>
    <input v-if="$route.name!='editor'" type="text"
           class="shadow appearance-none border rounded w-1/3 py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
           placeholder="Title or Artist" v-model="songStore.searchTerm" @input="songStore.getSongs()">
    <div class="border-x border-white">
      <button class=" text-white border-x border-white p-3 h-full m-0" @click="$router.push('artists')">
        <span class="font-bold">View Artists</span>
      </button>
      <button class=" text-white border-x border-white p-3 h-full m-0" @click="$router.push('editor')">
        <span class="font-bold">Add Song</span>
      </button>
    </div>
  </nav>
  <div class="flex justify-center">
    <Suspense fallback="loading">
      <router-view></router-view>
    </Suspense>
  </div>
</template>