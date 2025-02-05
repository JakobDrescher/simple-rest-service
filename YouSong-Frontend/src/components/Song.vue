<script setup>
import {useSongStore} from "@/stores/songStore.js";
import axios from "axios";

const props = defineProps(['title', 'artist', 'genre', 'length', 'id']);
const songStore = useSongStore();

function deleteSong() {
  axios.delete(`http://localhost:8888/api/songs/${props.id}`);
}
</script>

<template>
  <div class="relative mx-12 my-8 w-full sm:w-60">
    <div class="border-t-8 border-x-8 border-black p-4">
      <h1 class="font-bold text-xl truncate">{{ title }}</h1>
      <h2 class="text-xl truncate">by {{ artist }}</h2>
      <p class="text-sm truncate">Genre: {{ genre }}</p>
      <p class="text-lg truncate">{{ length }}</p>
    </div>
    <div class="absolute flex items-center justify-between -bottom-6 right-6 w-full">
      <button class="bg-black rounded-[50%] w-14 h-10 p-6 -ml-6 text-white" type="button"
              @click="deleteSong(); $router.go()">
        <div class="-ml-2 -mt-3">
          <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
               stroke="currentColor" class="size-6">
            <path stroke-linecap="round" stroke-linejoin="round"
                  d="m14.74 9-.346 9m-4.788 0L9.26 9m9.968-3.21c.342.052.682.107 1.022.166m-1.022-.165L18.16 19.673a2.25 2.25 0 0 1-2.244 2.077H8.084a2.25 2.25 0 0 1-2.244-2.077L4.772 5.79m14.456 0a48.108 48.108 0 0 0-3.478-.397m-12 .562c.34-.059.68-.114 1.022-.165m0 0a48.11 48.11 0 0 1 3.478-.397m7.5 0v-.916c0-1.18-.91-2.164-2.09-2.201a51.964 51.964 0 0 0-3.32 0c-1.18.037-2.09 1.022-2.09 2.201v.916m7.5 0a48.667 48.667 0 0 0-7.5 0"/>
          </svg>
        </div>
      </button>
      <button class="bg-black rounded-[50%] w-14 h-10 p-6 -mr-6 text-white" type="button"
              @click="songStore.changeSong(id); songStore.edit=true; $router.push('editor')">
        <div class="-ml-2 -mt-3">
          <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
               stroke="currentColor" class="size-6">
            <path stroke-linecap="round" stroke-linejoin="round"
                  d="m16.862 4.487 1.687-1.688a1.875 1.875 0 1 1 2.652 2.652L6.832 19.82a4.5 4.5 0 0 1-1.897 1.13l-2.685.8.8-2.685a4.5 4.5 0 0 1 1.13-1.897L16.863 4.487Zm0 0L19.5 7.125"/>
          </svg>
        </div>
      </button>
    </div>
  </div>
</template>