<template>
    <div>
        <ul v-for="book in books" :key="book.id">  
            Title: {{book.title}}, Autor: {{book.author}}
        </ul>
        </div>
</template>

<script>
export default {
  name: 'Booklist',
  data() {
    return {
      books: []
    }
  },
  mounted() {
    fetch("http://localhost:8081/books/author/Dan Brown")
    .then((response) => response.text())
      .then((data) => {
          this.books = JSON.parse(data);
      });
  }
}
</script>