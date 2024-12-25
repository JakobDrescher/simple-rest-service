<script setup>
const props = defineProps(['title', 'artist', 'genre', 'length']);
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
      <div class="bg-black rounded-[50%] w-14 h-10 p-6 -mr-6"></div>
    </div>
  </div>
</template>