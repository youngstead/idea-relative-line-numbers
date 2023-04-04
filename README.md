# Relative Line Numbers Plugin

A plugin to display relative line numbers on IDEA-based IDEs.

# How to install

<ul>
  <li>
    <div>
      <h4>
        Install the plugin via the Marketplace website or the IDE itself (Settings > Plugins > Marketplace)
      </h4>
      <p>
        If the line numbers are enabled (<i>Settings > Editor > General > Appearance > Show line numbers</i>), then you should be able to see the relative values immediately.
      </p>
      <p>
        <sup>*</sup>You may need to reopen your files for the plugin to take effect.
      </p>
    </div>
  <li>
    <h4>
      Configuration
    </h4>
    <p>
      As of version 1.1 you may also display the original (absolute) values next to the relative ones. To enable it, go to Settings > Editor > Line Numbers and enable the "Absolute values" checkbox. Changes should apply immediately after saving.
    </p>
  </li>
</ul>

# What it does

Displays line numbers relative to the caret's position. Optionally, you can
enable the original values as well, showing both at the same time.

![2022-05-19 16_43_26-idea-relative-line-numbers  H__Narduw_workspace_idea-relative-line-numbers – …_](https://user-images.githubusercontent.com/16376552/169325070-b6c6db64-3aea-4116-906f-59fd6d80fbc3.png)

# Why?

It can be useful to know how many lines you need to scroll up or down before you
do.
This plugin is a simple lightweight solution for that.

## Why not [IdeaVim](https://github.com/JetBrains/ideavim)?

If you like VIM, then yes, go ahead and use IdeaVim. It does the same and much
more!
However, if you don't need or want to use all other features of Vim,
this plugin offers a lightweight alternative
to the relative line numbers feature in particular.

# Recognition

This plugin was inspired
by [@vayafulano's plugin](https://plugins.jetbrains.com/plugin/7414-relative-line-numbers).

## Why not use the @vayafulano's plugin instead?

Despite being outdated and not searchable via the IDE, you can still install it
by downloading the JAR file directly and installing it manually. However,
this solution uses annotations to display the line numbers, which has several
implications, including the following:

* Regular and relative line numbers may both be displayed simultaneously
  but only as an unintentional side effect, outside the plugin's control.
* The relative line numbers may conflict with other annotations (e.g. VCS) and
  closing annotations will unintuitively remove the relative line numbers as
  well, causing confusion.

To address these issues, this plugin uses modern IntelliJ Platform SDK features
to replace line numbers with relative values. This should also improve
performance
(not measured) while avoiding conflicts with annotations.
