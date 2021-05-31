<template>
    <div>
      <div style="margin-bottom:10px;">
      Buchdatenbank:
      </div>
      <input v-model="title" placeholder="Titel eingeben">
      <input v-model="author" placeholder="Autor eingeben">
      <button v-on:click = "postBook">Buch posten</button>
      <div style="margin-bottom:10px; margin-top:20px;">
      Nach Autor filtern:
      </div>
      <input v-model="searchauthor" placeholder="Autor eingeben">
      <button v-on:click = "getBooksByAuthor">Suchen</button>
      <button v-on:click = "getBooks">Zurücksetzen</button>
        <ul v-for="book in books" :key="book.id">  
            Titel: {{book.title}}, Autor: {{book.author}}
        </ul>
    </div>
</template>

<script>
export default {
  name: 'Booklist',
  data() {
    return {
      books: [],
      title: "",
      author: "",
      searchauthor: "",
    }
  },
  mounted() {
    this.getBooks()
  },
  methods: {
      postBook: function() {
          if(this.title != "" && this.author != "") {
            const requestOptions = {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({title: this.title, author: this.author })
              };
          
            fetch("http://localhost:8081/book", requestOptions)
            .then(response => response.json())
            .then(() => {
              this.title = ""
              this.author = ""
              this.getBooks()
            })         
          }
      },
      getBooks: function() {
        fetch("http://localhost:8081/books")
        .then((response) => response.json())
        .then((data) => {
          this.books = data;
      });
      },

      getBooksByAuthor: function() {
        if(this.searchauthor != "") {
            fetch("http://localhost:8081/books/author/"+this.searchauthor)
            .then((response) => response.json())
            .then((data) => {
              this.books = data;
          });
        }
      }
  }
}
</script>