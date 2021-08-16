const arr = [0,1,2];

const iterableArr = arr[Symbol.iterator]();

console.log(iterableArr.next());
console.log(iterableArr.next().value);
console.log(iterableArr.next());
console.log(iterableArr.next());


const map = new Map();
map.set("key1","value1");
map.set("key2","value2");

const iterableMap = map[Symbol.iterator]();
console.log(iterableMap.next());
console.log(iterableMap.next().value);
console.log(iterableMap.next());

for (const [key, value]  of map) {
    console.log(`${key} - ${value}`)
}

const mySet = new Set();
mySet.add("key1");
mySet.add("key2");

const iterableSet = mySet[Symbol.iterator]();
console.log(iterableSet.next());
console.log(iterableSet.next().value);
console.log(iterableSet.next());

for (const value of mySet) {
    console.log(`${value}`)
}

for (const [i,j,k,l] of mySet) {
    console.log(`${i} , ${j} , ${k}, ${l}`)
}