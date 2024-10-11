<script setup>
import SongList from "@/components/SongList.vue";
</script>

<template>
  <Suspense fallback="loading">
    <SongList></SongList>
  </Suspense>
</template>