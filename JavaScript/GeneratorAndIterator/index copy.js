#! /usr/bin/env node

const readline = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout,
  prompt: 'enter command > ',
});

readline.prompt();

areadline.on('line', async line => {
  switch (line.trim()) {
    case 'list vegan foods':
      {
        axios.get(`http://localhost:3001/food`).then(({ data }) => {
          let idx = 0;
          const veganOnly = data.filter(food =>
            food.dietary_preferences.includes('vegan'),
          );
          const veganIterable = {
            [Symbol.iterator]() {
              return {
                [Symbol.iterator]() {
                  return this;
                },
                next() {
                  const current = veganOnly[idx];
                  idx++;
                  if (current) {
                    return { value: current, done: false };
                  } else {
                    return { value: current, done: true };
                  }
                },
              };
            },
          };
          for (let val of veganIterable) {
            console.log(val.name);
          }
          readline.prompt();
        });
      }
      break;
    }
    readline.prompt();
  });