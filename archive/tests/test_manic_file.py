#!/usr/bin/env python3

import pytest

@pytest.mark.usefixtures("manic_miner_file")
def test_filename(manic_miner_file):
    assert manic_miner_file.filename == "manic/data/Manic Miner.tzx"
