<script setup>
import {ref} from "vue";
import axios from "axios";
import {useSongStore} from "@/stores/songStore.js";

const songStore = useSongStore();

const id = ref(songStore.song.id);
const title = ref(songStore.song.title);
const artist = ref(songStore.song.artist);
const genre = ref(songStore.song.genre);
const length = ref(songStore.song.length);



function createSong() {
  axios.post("http://localhost:8888/api/songs", {
    title: title.value,
    artist: artist.value,
    genre: genre.value,
    length: parseTime(length.value),
  });
}

function editSong() {
  axios.put(`http://localhost:8888/api/songs/${id}`, {
    title: title.value,
    artist: artist.value,
    genre: genre.value,
    length: parseTime(length.value),
  });
}

function parseTime(time) {
  let result = new Date();
  let sections = time.split(":");
  result.setSeconds(sections[sections.length - 1]);
  if (sections.length > 1) {
    result.setMinutes(sections[sections.length - 2]);
  } else {
    result.setMinutes(0);
  }
  if (sections.length > 2) {
    result.setHours(sections[sections.length - 3]);
  } else {
    result.setHours(0);
  }

  return result.toTimeString().split(" ")[0];
}
</script>

<template>
  <form class="relative mx-12 my-8 w-full">
    <div class="border-t-8 border-x-8 border-black p-4">
      <div class="mb-4">
        <label class="block text-gray-700 text-sm font-bold mb-2" for="title">
          Song Title
        </label>
        <input
            class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
            id="title" type="text" placeholder="Title" v-model="title">
      </div>
      <div class="mb-4">
        <label class="block text-gray-700 text-sm font-bold mb-2" for="artist">
          Artist
        </label>
        <input
            class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
            id="artist" type="text" placeholder="Artist" v-model="artist">
      </div>
      <div class="mb-4">
        <label class="block text-gray-700 text-sm font-bold mb-2" for="genre">
          Genre
        </label>
        <input
            class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
            id="genre" type="text" placeholder="Genre" v-model="genre">
      </div>
      <div class="mb-4">
        <label class="block text-gray-700 text-sm font-bold mb-2" for="length">
          Length
        </label>
        <input
            class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
            id="length" type="text" placeholder="Length" v-model="length">
      </div>
    </div>
    <div class="absolute flex items-center justify-between -bottom-6 right-6 w-full">
      <button v-if="songStore.edit" class="bg-black rounded-[50%] w-14 h-10 p-6 -ml-6 text-white" type="button"
              @click="editSong(); $router.push('/')">
        <div class="-ml-2 -mt-3">
          <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
               stroke="currentColor" class="size-6">
            <path stroke-linecap="round" stroke-linejoin="round" d="m4.5 12.75 6 6 9-13.5"/>
          </svg>
        </div>
      </button>
      <button v-else class="bg-black rounded-[50%] w-14 h-10 p-6 -ml-6 text-white" type="button"
              @click="createSong(); $router.push('/')">
        <div class="-ml-2 -mt-3">
          <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
               stroke="currentColor" class="size-6">
            <path stroke-linecap="round" stroke-linejoin="round" d="m4.5 12.75 6 6 9-13.5"/>
          </svg>
        </div>
      </button>
      <button class="bg-black rounded-[50%] w-14 h-10 p-6 -mr-6 text-white" type="button" @click="$router.push('/')">
        <div class="-ml-2 -mt-3">
          <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
               stroke="currentColor" class="size-6">
            <path stroke-linecap="round" stroke-linejoin="round" d="M6 18 18 6M6 6l12 12"/>
          </svg>
        </div>
      </button>
    </div>
  </form>
</template>