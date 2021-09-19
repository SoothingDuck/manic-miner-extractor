#!/usr/bin/env python3
import os
from bitarray.util import int2ba, ba2int

class ManicMinerColorAttribute():

    # A colour-attribute is represented as an 8-bit word in the following format (see Appendix D):
    # FBPPPIII
    # where:
    # F represents flash (0=not flashing, 1=flashing);
    # B represents brightness (0=not bright, 1=bright);
    # PPP represents paper colour (000=black, 001=blue, 010=red, 011=magenta, 100=green, 101=cyan, 110=yellow, 111=white);
    # III represents ink colour (as above).

    BLACK = 0
    BLUE = 1
    RED = 2
    MAGENTA = 3
    GREEN = 4
    CYAN = 5
    YELLOW = 6
    WHITE = 7

    def __init__(self, character):
        self._character = character
        self._ba = int2ba(int(character), 8)

    @property
    def flash(self):
        return self._ba[0] == 1

    @property
    def brightness(self):
        return self._ba[1] == 1

    @property
    def paper_colour(self):
        return ba2int(self._ba[2:5])

    @property
    def ink_colour(self):
        return ba2int(self._ba[5:8])
    
class ManicMinerRoomLayout():

    def __init__(self, buffer):
        self._buffer = buffer

    @property
    def colors(self):
        result = []
        for i in range(16):
            tmp = []
            for j in range(32):
                tmp.append(ManicMinerColorAttribute(self._buffer[(i*32)+j]))
            result.append(tmp)
        return(result)


class ManicMinerRoom():

    MAGIC_OFFSET_SCREEN_LAYOUT = 0
    MAGIC_OFFSET_ROOM_NAME = 512

    def __init__(self, buffer):
        self._buffer = buffer

    @property
    def name(self):
        return self._buffer[ManicMinerRoom.MAGIC_OFFSET_ROOM_NAME:(ManicMinerRoom.MAGIC_OFFSET_ROOM_NAME+32)].strip().decode("utf8")

    @property
    def layout(self):
        return ManicMinerRoomLayout(self._buffer[ManicMinerRoom.MAGIC_OFFSET_SCREEN_LAYOUT:(ManicMinerRoom.MAGIC_OFFSET_SCREEN_LAYOUT+512)])

class ManicMinerFile():

    MAGIC_OFFSET_CENTRAL_CAVERN = int("33B4", 16) - 512

    def __init__(self):
        self._filename = os.path.join("manic", "data", "Manic Miner.tzx")
        self._file = open(self._filename, "rb")

    @property
    def filename(self):
        return self._filename


    @property
    def rooms(self):
        self._file.seek(ManicMinerFile.MAGIC_OFFSET_CENTRAL_CAVERN)
        for i in range(20):
            buffer = self._file.read(1024)
            yield ManicMinerRoom(buffer)
