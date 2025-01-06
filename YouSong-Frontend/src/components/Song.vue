<script setup>
import {useSongStore} from "@/stores/songStore.js";

const props = defineProps(['title', 'artist', 'genre', 'length', 'id']);
const songStore = useSongStore();
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
      <div class="bg-black rounded-[50%] w-14 h-10 p-6 -ml-6"></div>
      <button class="bg-black rounded-[50%] w-14 h-10 p-6 -mr-6 text-white" type="button" @click="songStore.changeSong(id,title,artist,genre,length); songStore.edit=true; $router.push('editor')">
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