import { morseAlphabet } from './MorseAlphabet'

/**
 * Checks if a message contains illegal characters.
 * 
 * @msg String containing the message that is going to be checked.
 * @return boolean, if it contains illegal characters then return false,
 *         otherwise true.
 */
export const verifyMessage = (msg) => {
    var flag = true;
    Array.from(msg).forEach((ch) => {
        if (!testChar(ch)) {
            flag = false;
        }
    })
    return flag;
}

const testChar = (ch) => {
    var flag = false;
    morseAlphabet.forEach(i => {
        if (i[0].charAt(0) == ch.toLowerCase())
            flag = true;
    })
    return flag;
}

export default verifyMessage