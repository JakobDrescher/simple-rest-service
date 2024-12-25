<script setup>
import SongList from "@/components/SongList.vue";
</script>

<template>
  <div class="flex justify-center">
  <Suspense fallback="loading">
    <SongList></SongList>
  </Suspense>
  </div>
</template>