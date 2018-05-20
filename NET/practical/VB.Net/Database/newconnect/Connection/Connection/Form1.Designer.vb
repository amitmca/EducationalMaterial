<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form1
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        If disposing AndAlso components IsNot Nothing Then
            components.Dispose()
        End If
        MyBase.Dispose(disposing)
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.components = New System.ComponentModel.Container
        Me.DataGridView1 = New System.Windows.Forms.DataGridView
        Me.AmitDataSet = New Connection.amitDataSet
        Me.AmitDataSetBindingSource = New System.Windows.Forms.BindingSource(Me.components)
        Me.EmpBindingSource = New System.Windows.Forms.BindingSource(Me.components)
        Me.EmpTableAdapter = New Connection.amitDataSetTableAdapters.empTableAdapter
        Me.EnoDataGridViewTextBoxColumn = New System.Windows.Forms.DataGridViewTextBoxColumn
        Me.EnameDataGridViewTextBoxColumn = New System.Windows.Forms.DataGridViewTextBoxColumn
        Me.Button1 = New System.Windows.Forms.Button
        CType(Me.DataGridView1, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.AmitDataSet, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.AmitDataSetBindingSource, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.EmpBindingSource, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'DataGridView1
        '
        Me.DataGridView1.AutoGenerateColumns = False
        Me.DataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize
        Me.DataGridView1.Columns.AddRange(New System.Windows.Forms.DataGridViewColumn() {Me.EnoDataGridViewTextBoxColumn, Me.EnameDataGridViewTextBoxColumn})
        Me.DataGridView1.DataSource = Me.EmpBindingSource
        Me.DataGridView1.Dock = System.Windows.Forms.DockStyle.Fill
        Me.DataGridView1.Location = New System.Drawing.Point(0, 0)
        Me.DataGridView1.Name = "DataGridView1"
        Me.DataGridView1.Size = New System.Drawing.Size(292, 266)
        Me.DataGridView1.TabIndex = 0
        '
        'AmitDataSet
        '
        Me.AmitDataSet.DataSetName = "amitDataSet"
        Me.AmitDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema
        '
        'AmitDataSetBindingSource
        '
        Me.AmitDataSetBindingSource.DataSource = Me.AmitDataSet
        Me.AmitDataSetBindingSource.Position = 0
        '
        'EmpBindingSource
        '
        Me.EmpBindingSource.DataMember = "emp"
        Me.EmpBindingSource.DataSource = Me.AmitDataSet
        '
        'EmpTableAdapter
        '
        Me.EmpTableAdapter.ClearBeforeFill = True
        '
        'EnoDataGridViewTextBoxColumn
        '
        Me.EnoDataGridViewTextBoxColumn.DataPropertyName = "eno"
        Me.EnoDataGridViewTextBoxColumn.HeaderText = "eno"
        Me.EnoDataGridViewTextBoxColumn.Name = "EnoDataGridViewTextBoxColumn"
        '
        'EnameDataGridViewTextBoxColumn
        '
        Me.EnameDataGridViewTextBoxColumn.DataPropertyName = "ename"
        Me.EnameDataGridViewTextBoxColumn.HeaderText = "ename"
        Me.EnameDataGridViewTextBoxColumn.Name = "EnameDataGridViewTextBoxColumn"
        '
        'Button1
        '
        Me.Button1.Location = New System.Drawing.Point(94, 155)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(75, 23)
        Me.Button1.TabIndex = 1
        Me.Button1.Text = "Button1"
        Me.Button1.UseVisualStyleBackColor = True
        '
        'Form1
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(292, 266)
        Me.Controls.Add(Me.Button1)
        Me.Controls.Add(Me.DataGridView1)
        Me.Name = "Form1"
        Me.Text = "Form1"
        CType(Me.DataGridView1, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.AmitDataSet, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.AmitDataSetBindingSource, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.EmpBindingSource, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)

    End Sub
    Friend WithEvents DataGridView1 As System.Windows.Forms.DataGridView
    Friend WithEvents AmitDataSetBindingSource As System.Windows.Forms.BindingSource
    Friend WithEvents AmitDataSet As Connection.amitDataSet
    Friend WithEvents EmpBindingSource As System.Windows.Forms.BindingSource
    Friend WithEvents EmpTableAdapter As Connection.amitDataSetTableAdapters.empTableAdapter
    Friend WithEvents EnoDataGridViewTextBoxColumn As System.Windows.Forms.DataGridViewTextBoxColumn
    Friend WithEvents EnameDataGridViewTextBoxColumn As System.Windows.Forms.DataGridViewTextBoxColumn
    Friend WithEvents Button1 As System.Windows.Forms.Button

End Class
