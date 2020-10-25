var { graphql, buildSchema } = require('graphql');

var schema = buildSchema(`
  type Query {
    hello: String,
    name: rajiv
  }
`);

var root = { rajiv: () => 'Hello world!' };

graphql(schema, '{ hello,rajiv }', root).then((response) => {
  console.log(response);
});