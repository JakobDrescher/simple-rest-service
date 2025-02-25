<script setup>
import {useArtistStore} from "@/stores/artistStore.js";
import {ref} from "vue";

const artistStore = useArtistStore();

const id = ref(artistStore.currentArtist.id);
const name = ref(artistStore.currentArtist.name);
</script>

<template>
  <form class="relative mx-12 my-8 w-full">
    <div class="border-t-8 border-x-8 border-black p-4">
      <div class="mb-4">
        <label class="block text-gray-700 text-sm font-bold mb-2" for="title">
          Artist Name
        </label>
        <input
            class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
            id="title" type="text" placeholder="Title" v-model="name">
      </div>
    </div>
    <div class="absolute flex items-center justify-between -bottom-6 right-6 w-full">
      <button v-if="artistStore.edit" class="bg-black rounded-[50%] w-14 h-10 p-6 -ml-6 text-white" type="button"
              @click="artistStore.editArtist(id, name); $router.push('/artists')">
        <div class="-ml-2 -mt-3">
          <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
               stroke="currentColor" class="size-6">
            <path stroke-linecap="round" stroke-linejoin="round" d="m4.5 12.75 6 6 9-13.5"/>
          </svg>
        </div>
      </button>
      <button v-else class="bg-black rounded-[50%] w-14 h-10 p-6 -ml-6 text-white" type="button"
              @click="artistStore.createArtist(name); $router.push('/artists')">
        <div class="-ml-2 -mt-3">
          <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
               stroke="currentColor" class="size-6">
            <path stroke-linecap="round" stroke-linejoin="round" d="m4.5 12.75 6 6 9-13.5"/>
          </svg>
        </div>
      </button>
      <button class="bg-black rounded-[50%] w-14 h-10 p-6 -mr-6 text-white" type="button" @click="artistStore.changeArtist(); $router.push('/artists')">
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