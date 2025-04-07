<script setup>
import {ref,computed} from "vue";
import { useVuelidate } from '@vuelidate/core';
import { required, minLength } from '@vuelidate/validators';
import {useSongStore} from "@/stores/songStore.js";
import {useArtistStore} from "@/stores/artistStore.js";

const songStore = useSongStore();
const artistStore = useArtistStore();

const id = ref(songStore.currentSong.id);
const title = ref(songStore.currentSong.title);
const artist = ref(artistStore.artists.find(artist => artist.name === songStore.currentSong.artist));
const genre = ref(songStore.currentSong.genre);
const length = ref(songStore.currentSong.length);

const rules = computed(() => ({
  title: { required, minLength: minLength(2) },
  artist: { required },
  genre: { required },
  length: { required }
}));

const v$ = useVuelidate(rules, { title, artist, genre, length });

// Submit handlers
async function handleSubmit() {
  const isValid = await v$.value.$validate();
  if (!isValid) return;

  songStore.createSong(title, artist, genre, length);
  $router.push('/');
}

async function handleEdit() {
  const isValid = await v$.value.$validate();
  if (!isValid) return;

  songStore.editSong(id, title, artist, genre, length);
  $router.push('/');
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
            id="title" type="text" placeholder="Title" v-model="title" @blur="v$.title.$touch()">
      </div>
      <div class="mb-4">
        <label class="block text-gray-700 text-sm font-bold mb-2" for="artist">
          Artist
        </label>
        <select id ="artist" class="shadow border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" v-model="artist" @blur="v$.artist.$touch()">
          <option selected disabled value="undefined">--choose artist--</option>
          <option v-for="artist in artistStore.artists" v-bind:value="artist">{{artist.name}}</option>
        </select>
      </div>
      <div class="mb-4">
        <label class="block text-gray-700 text-sm font-bold mb-2" for="genre">
          Genre
        </label>
        <input
            class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
            id="genre" type="text" placeholder="Genre" v-model="genre" @blur="v$.genre.$touch()">
      </div>
      <div class="mb-4">
        <label class="block text-gray-700 text-sm font-bold mb-2" for="length">
          Length
        </label>
        <input
            class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
            id="length" type="text" placeholder="Length" v-model="length" @blur="v$.length.$touch()">
      </div>
      <p v-if="v$.title.$error" class="text-red-500 text-sm">Title is required.</p>
      <p v-if="v$.genre.$error" class="text-red-500 text-sm">Genre is required.</p>
      <p v-if="v$.artist.$error" class="text-red-500 text-sm">Please select an artist.</p>
      <p v-if="v$.length.$error" class="text-red-500 text-sm">Length is required.</p>
    </div>
    <div class="absolute flex items-center justify-between -bottom-6 right-6 w-full">
      <button v-if="songStore.edit" class="bg-black rounded-[50%] w-14 h-10 p-6 -ml-6 text-white" type="button"
              @click="handleEdit()">
        <div class="-ml-2 -mt-3">
          <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
               stroke="currentColor" class="size-6">
            <path stroke-linecap="round" stroke-linejoin="round" d="m4.5 12.75 6 6 9-13.5"/>
          </svg>
        </div>
      </button>
      <button v-else class="bg-black rounded-[50%] w-14 h-10 p-6 -ml-6 text-white" type="button"
              @click="handleSubmit()">
        <div class="-ml-2 -mt-3">
          <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
               stroke="currentColor" class="size-6">
            <path stroke-linecap="round" stroke-linejoin="round" d="m4.5 12.75 6 6 9-13.5"/>
          </svg>
        </div>
      </button>
      <button class="bg-black rounded-[50%] w-14 h-10 p-6 -mr-6 text-white" type="button" @click="songStore.changeSong(); $router.push('/')">
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