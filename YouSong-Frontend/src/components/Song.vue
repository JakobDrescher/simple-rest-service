<script setup>
const props = defineProps(['title', 'artist', 'genre', 'length']);
</script>

<template>
  <div class="relative ml-14 my-12 w-full md:w-fit">
    <div class="border-t-8 border-x-8 border-black p-8">
      <h1 class="font-bold text-xl">{{ title }}</h1>
      <h2 class="text-lg">by {{ artist }}</h2>
      <sup>Genre: {{ genre }}</sup>
      <p class="text-lg">{{ length }}</p>
    </div>
    <div class="absolute flex items-center justify-between -bottom-6 w-full">
      <div class="bg-black rounded-[50%] w-14 h-10 p-6 -ml-12 -rotate-12"></div>
      <div class="bg-black rounded-[50%] w-14 h-10 p-6 -ml-12 -rotate-12"></div>
    </div>
  </div>
</template>