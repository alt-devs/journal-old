<template lang="pug">
  v-form
    v-container
      v-layout
        v-flex(md12)
          v-text-field(
            :value="formData.name"
            :label="$t('admin.profile.fields.name')"
            @keyup.stop="updateField('firstname', $event.target.value)"
          )
          v-text-field(
            :value="formData.slogan"
            :label="$t('admin.profile.fields.slogan')"
            @keyup.stop="updateField('firstname', $event.target.value)"
          )
          v-select(
            :value="formData.industries"
            :label="$t('admin.profile.fields.industries')"
            :items="industries"
            @change="updateField('industries', $event)"
            chips
            multiple
          )

          v-btn(
            color="primary"
            @click="editProfile"
          ) {{ $t('admin.profile.fields.save') }}
</template>

<script lang="ts">
import { Vue, Component, State, Watch } from 'nuxt-property-decorator'

@Component
export default class ProfileManager extends Vue {
  @State(state => state.admin.industries.data) industries
  @State(state => state.admin.profile.data) profileData

  get formData() {
    return this.profileData
  }

  set formData(values) {
    this.formData = this.profileData
  }

  mounted() {
    console.log(this.$apolloHelpers.getToken())
  }

  updateField(field, value) {
    this.$store.commit('admin/profile/updateField', {
      [field]: value
    })
  }

  editProfile() {
    this.$store.commit('admin/profile/putProfile')
  }
}
</script>

<style lang="stylus" scoped></style>
