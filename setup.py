#!/usr/bin/env python3

from setuptools import setup

setup(name="manic",
      version="0.0.1",
      description="A tool to parse manic miner file",
      author="Yvan Aillet",
      author_email="yvanaillet@gmail.com",
      packages=["manic", "tests"],
      package_data={'manic': ['data/*.tzx']},
      install_requires=["Pillow", "bitarray", "pytest"],
      license="Apache 2.0")
