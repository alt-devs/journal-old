<template lang="pug">
  div admin main page
</template>

<script lang="ts">
export default {
  layout: 'admin',
  head() {
    return {
      title: this.$t('admin.index')
    }
  }
}
</script>
