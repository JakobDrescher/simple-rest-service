<script setup>
const props = defineProps(['title', 'artist', 'genre', 'length']);
</script>

<template>
  <div class="relative m-16">
    <div class="border-t-8 border-x-8 border-black p-4">
      <h1>{{ title }}</h1>
      <h2>by {{ artist }}</h2>
      <p>Genre: {{ genre }}</p>
      <p>{{ length }}</p>
    </div>
    <div class="absolute flex items-center justify-between -bottom-6 right-6 w-full">
      <div class="bg-black rounded-[50%] w-14 h-10 p-6 -ml-6"></div>
      <div class="bg-black rounded-[50%] w-14 h-10 p-6 -mr-6"></div>
    </div>
  </div>
</template>