<script setup>
const props = defineProps(['title', 'artist', 'genre', 'length']);
</script>

<template>
  <h1>{{ title }}</h1>
  <h2>by {{artist}}</h2>
  <p>{{ genre }}</p>
  <p>{{ length }}</p>
</template>