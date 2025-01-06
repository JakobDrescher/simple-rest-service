<script setup>
import SongList from "@/components/SongList.vue";
</script>

<template>
  <nav class="bg-black p-5 flex flex-row justify-evenly items-center">
    <h1 class="text-white font-extrabold text-6xl pb-3 cursor-pointer" @click="$router.push('/')">YouSong</h1>
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