function myIterator(start, finish){

    let index = start;
    let count = 0;

    return {
        next(){
            let result ;
            if(index < finish){
                result = {value : index , done: false};
                index+=1;
                count++;
                return result;
            }
            return {
                value:count,
                done: true
            }
        }
    }
}

const mySampleIterator = myIterator(0,10);

for (let value, result ; (result = mySampleIterator.next()) && !result.done;   ) 
    console.log(result.value);

